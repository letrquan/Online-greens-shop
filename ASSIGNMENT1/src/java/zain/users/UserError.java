/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.users;

/**
 *
 * @author quan2
 */
public class UserError {

    private String userIDerror;
    private String fullNameerror;
    private String passworderror;
    private String roleIDerror;
    private String Confirmpassworderror;
    private String addresserror;
    private String phoneerror;
    private String statusIDerror;
    private String createDateerror;

    public String getAddresserror() {
        return addresserror;
    }

    public void setAddresserror(String addresserror) {
        this.addresserror = addresserror;
    }

    public String getPhoneerror() {
        return phoneerror;
    }

    public void setPhoneerror(String phoneerror) {
        this.phoneerror = phoneerror;
    }

    public String getStatusIDerror() {
        return statusIDerror;
    }

    public void setStatusIDerror(String statusIDerror) {
        this.statusIDerror = statusIDerror;
    }

    public String getCreateDateerror() {
        return createDateerror;
    }

    public void setCreateDateerror(String createDateerror) {
        this.createDateerror = createDateerror;
    }

    public UserError() {
        this.Confirmpassworderror = "";
        this.passworderror = "";
        this.userIDerror = "";
        this.roleIDerror = "";
        this.fullNameerror = "";
        this.addresserror = "";
        this.createDateerror = "";
        this.phoneerror = "";
        this.statusIDerror="";
    }

    public UserError(String userIDerror, String fullNameerror, String passworderror, String roleIDerror, String Confirmpassworderror, String addresserror, String phoneerror, String statusIDerror, String createDateerror) {
        this.userIDerror = userIDerror;
        this.fullNameerror = fullNameerror;
        this.passworderror = passworderror;
        this.roleIDerror = roleIDerror;
        this.Confirmpassworderror = Confirmpassworderror;
        this.addresserror = addresserror;
        this.phoneerror = phoneerror;
        this.statusIDerror = statusIDerror;
        this.createDateerror = createDateerror;
    }

    public String getUserIDerror() {
        return userIDerror;
    }

    public void setUserIDerror(String userIDerror) {
        this.userIDerror = userIDerror;
    }

    public String getFullNameerror() {
        return fullNameerror;
    }

    public void setFullNameerror(String fullNameerror) {
        this.fullNameerror = fullNameerror;
    }

    public String getPassworderror() {
        return passworderror;
    }

    public void setPassworderror(String passworderror) {
        this.passworderror = passworderror;
    }

    public String getRoleIDerror() {
        return roleIDerror;
    }

    public String getConfirmpassworderror() {
        return Confirmpassworderror;
    }

    public void setConfirmpassworderror(String Confirmpassworderror) {
        this.Confirmpassworderror = Confirmpassworderror;
    }

    public void setRoleIDerror(String roleIDerror) {
        this.roleIDerror = roleIDerror;
    }

}
