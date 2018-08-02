package linearFramework;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.commons.lang3.time.StopWatch;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Executor {

    /**
     * main method to run the framework test cases
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = null;
        Recordset recordset = null;
        Executor exeKey = new Executor();
        String methodName;
        String stepId;
        int sheetNumber = Integer.parseInt(System.getenv("KEYWORDEXCELSHEETNUMBER"));
        String filePath = System.getenv("KEYWORDEXCELPATH");
        //int sheetNumber = 1;

        boolean status;
        try {
            Fillo fillo = new Fillo();
            List<Object> myParamList = new ArrayList<Object>();
            //connection = fillo.getConnection(new File("keyworddriven.xlsx").getAbsolutePath());
            connection = fillo.getConnection(new File(filePath).getAbsolutePath());
            String strQuery = "Select * from Sheet" + sheetNumber + " where testcase is not null";
            recordset = connection.executeQuery(strQuery);
            while (recordset.next()) {
                methodName = recordset.getField("testcase");
                stepId = recordset.getField("stepid");
                for (String columnName : recordset.getFieldNames()) {
                    //to ignore all the unwanted details from the excel
                    if (!columnName.equalsIgnoreCase("testcase")
                            & (!columnName.equalsIgnoreCase("stepid"))
                            & (!columnName.equalsIgnoreCase("ExeDate"))
                            & (!columnName.equalsIgnoreCase("Results"))
                            & (!columnName.equalsIgnoreCase("ExeDuration"))) {
                        if (!recordset.getField(columnName).isEmpty()
                                & !recordset.getField(columnName).contentEquals("null")) {
                            //add only the required arguments values to array list
                            myParamList.add(recordset.getField(columnName));
                        }
                    }
                }
                Object[] paramListObject = new String[myParamList.size()];
                paramListObject = myParamList.toArray(paramListObject);
                StopWatch pageLoad = new StopWatch();
                pageLoad.start();
                status = exeKey.runReflectionMethod("framework.Keywords",
                        methodName, paramListObject);
                pageLoad.stop();
                int duration = Integer.parseInt(String.valueOf(pageLoad.getTime(TimeUnit.SECONDS)));
                if (status == true) {
                    connection.executeUpdate("Update Sheet" + sheetNumber + " Set Results='PASS' ,ExeDate='"+ Util.getCurrentDateByFormat("dd-MMM-YYYY") +"', ExeDuration="+duration+" where testcase= '" + methodName + "' and stepid ='"+stepId+"'");
                } else {
                    connection.executeUpdate("Update Sheet" + sheetNumber + " Set Results='FAIL' ,ExeDate='"+ Util.getCurrentDateByFormat("dd-MMM-YYYY") +"', ExeDuration="+duration+" where testcase= '" + methodName + "' and stepid ='"+stepId+"'");
                }
                myParamList.clear();
            }
        } catch (FilloException e) {
            System.err.format(e + "");
            recordset.close();
            connection.close();
            System.exit(0);
        } finally {
            recordset.close();
            connection.close();
            System.exit(0);
        }
    }

    /**
     * method to run the method names using java reflection
     * @param strClassName
     * @param strMethodName
     * @param inputArgs
     * @return
     */
    public boolean runReflectionMethod(String strClassName, String strMethodName,
                                       Object... inputArgs) {
        boolean result = false;

        Class<?> params[] = new Class[inputArgs.length];

        for (int i = 0; i < inputArgs.length; i++) {
            if (inputArgs[i] instanceof String) {
                params[i] = String.class;
            }
        }
        try {
            Class<?> cls = Class.forName(strClassName);
            Object _instance = cls.newInstance();
            Method myMethod = cls.getDeclaredMethod(strMethodName, params);
            myMethod.invoke(_instance, inputArgs);
            result = true;
        } catch (ClassNotFoundException e) {
            System.err.format(strClassName + ":- Class not found%n");
        } catch (IllegalArgumentException e) {
            System.err
                    .format("Method invoked with wrong number of arguments%n");
        } catch (NoSuchMethodException e) {
            System.err.format("In Class " + strClassName + "::" + strMethodName
                    + ":- method does not exists%n");

        } catch (InvocationTargetException e) {
            System.err.format("Exception thrown by an invoked method%n");

        } catch (IllegalAccessException e) {
            System.err
                    .format("Can not access a member of class with modifiers private%n");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err
                    .format("Object cannot be instantiated for the specified class using the newInstance method%n");
        }
        return result;
    }
}
