package com.timothy.common.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/12 16:27
 */
public class TreeRecode {
    private String signature;
    private Long useTime;

    @JsonIgnore
    private TreeRecode parentNode;

    private final List<TreeRecode> childNodes = new ArrayList<>();

    @Override
    public String toString() {
        return new StringJoiner(", ", TreeRecode.class.getSimpleName() + "[", "]")
                .add("signature='" + signature + "'")
                .add("useTime=" + useTime)
                .add("childNodes=" + childNodes)
                .toString();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Long getUseTime() {
        return useTime;
    }

    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    public TreeRecode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeRecode parentNode) {
        this.parentNode = parentNode;
    }

    public void add(TreeRecode childNode) {
        this.childNodes.add(childNode);
    }
}
