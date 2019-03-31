package com.ghsong.springmvc;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Getter
@Setter
public class Person {
    private Long id;
    private String name;
}
