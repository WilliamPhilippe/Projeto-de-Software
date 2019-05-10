package com.company;

public interface Employees {

    int getEmployeeNumber();
    String getName();
    void getAddress();
    String getType();
    int getSyndicateNumber();
    boolean getSyndicateIs();

    void setName(String name);
    void setAddress(String address);
    void setType(String type);
    void setEmployeeNumber(int employeeNumber);
    void setPaymentMethod();
    void setSyndicateNumber(int number);
    void setSyndicateIs(boolean is);
    void setSyndicateFee(double fee);
    void setDiscout(int discout);

    void removeEmployee(int employeeNumber);

}
