package com.example.web;


import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

public class MissingServletRequestPartFailureAnalyzer extends AbstractFailureAnalyzer<MissingServletRequestPartException> {


    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, MissingServletRequestPartException cause) {
        StringBuilder description = new StringBuilder();
        description.append(cause.getMessage());
        return new FailureAnalysis(description.toString(),
                "Update your application to provide the missing servlet request part.", cause);
    }
}
