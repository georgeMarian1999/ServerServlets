package com.server.model;

import jdk.internal.org.jline.utils.AttributedCharSequence;

import java.util.HashMap;

public class AgendaBean {
    public String opId;
    public HashMap<String, Object>[] resCauta;
    public String contact;

    public void setSir(String sir) {
    }

    public void setCare(String care) {

    }

    public void setUrgent(String urgent) {

    }

    public void setLongPage(String longPage) {

    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public void setCurrentPage(String substring) {

    }
}
