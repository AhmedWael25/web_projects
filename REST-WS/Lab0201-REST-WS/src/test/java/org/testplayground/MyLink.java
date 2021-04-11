package  org.testplayground;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;



import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @NoArgsConstructor @ToString
public class MyLink{

    private String uri;
    private String rel;


}