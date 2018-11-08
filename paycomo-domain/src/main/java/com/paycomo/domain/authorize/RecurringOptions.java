package com.paycomo.domain.authorize;

public class RecurringOptions {
    private boolean loanPayment;
    private boolean firstRecurringPayment;

    public boolean isLoanPayment() {
        return loanPayment;
    }

    public void setLoanPayment(boolean loanPayment) {
        this.loanPayment = loanPayment;
    }

    public boolean isFirstRecurringPayment() {
        return firstRecurringPayment;
    }

    public void setFirstRecurringPayment(boolean firstRecurringPayment) {
        this.firstRecurringPayment = firstRecurringPayment;
    }
}
