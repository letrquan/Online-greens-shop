/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.shopping;

/**
 *
 * @author quan2
 */
public class OrderError {

    private String addresserror;
    private String phoneerror;

    public OrderError(String addresserror, String phoneerror) {
        this.addresserror = addresserror;
        this.phoneerror = phoneerror;
    }

    public OrderError() {
        this.addresserror = "";
        this.phoneerror = "";
    }

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

}
