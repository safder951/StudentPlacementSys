package com.example.studentplacementsys;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public class Companylist {
    String CompanyName;
    String CompanyDescrption;
    String CompanyJobDescp;

    public Companylist(String CompanyName, String CompanyDescription, String CompanyJobDescp) {
        this.CompanyName = CompanyName;
        this.CompanyDescrption = CompanyDescription;
        this.CompanyJobDescp = CompanyJobDescp;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getCompanyDescrption() {
        return CompanyDescrption;
    }

    public String getCompanyJobDescp() {
        return CompanyJobDescp;
    }

}
