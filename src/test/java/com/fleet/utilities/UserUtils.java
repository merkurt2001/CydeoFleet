package com.fleet.utilities;

public class UserUtils {
    public static String username = null;
    public static String password = null;

    public static void UserGenerator(String userType) {

        switch (userType) {
            case "driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "store manager":
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");
                break;
            case "sales manager":
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break;
            default:
                System.out.println("INVALID user type");
                break;
        }


    }


}
