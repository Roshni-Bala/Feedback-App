package com.example.test_roshni;

import static com.example.test_roshni.FeedbackFormActivity.user_email;

public class NewUserFeedback {
    private String u_feedback;
    private int u_rate;
    private String u_email = user_email;

    public NewUserFeedback(){
//empty
    }

    public NewUserFeedback( String u_feedback, int u_rate) {
//        this.u_email = u_email;
        this.u_feedback = u_feedback;
        this.u_rate = u_rate;
    }

    public String getU_feedback() {
        return u_feedback;
    }

    public void setU_feedback(String u_feedback) {
        this.u_feedback = u_feedback;
    }

    public int getU_rate() {
        return u_rate;
    }

    public void setU_rate(int u_rate) {
        this.u_rate = u_rate;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }
}
