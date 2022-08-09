package com.snailvoyager.springbooteatgo.domain;

import java.util.regex.Pattern;

public class Version implements Comparable<Version>{
    private String version;

    public Version(String version) {
        if (version == null) {
            throw new IllegalArgumentException("version must not be null!");
        }

        if (!Pattern.matches("\\d+(\\.\\d+){0,2}(-SNAPSHOT)?", version)) {
            throw new IllegalArgumentException("version must match");
        }
        this.version = version;
    }

    public boolean isSnapshot(){
        return version.contains("-SNAPSHOT");
    }


    @Override
    public int compareTo(Version o) {
        return 0;
    }
}
