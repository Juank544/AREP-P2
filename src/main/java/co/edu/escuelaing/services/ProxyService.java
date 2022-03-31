package co.edu.escuelaing.services;

import java.util.ArrayList;
import java.util.List;

public class ProxyService {
    Integer pos = 0;

    public String getEC2(){
        List<String> URLlist = new ArrayList<>();
        URLlist.add("ec2-18-206-248-59.compute-1.amazonaws.com:4567");
        URLlist.add("ec2-54-160-247-84.compute-1.amazonaws.com:4567");

        String target = null;

        synchronized (pos){
            if (pos >= URLlist.size()){
                pos = 0;
            }

            target = URLlist.get(pos);
            pos++;
        }
        return target;
    }
}
