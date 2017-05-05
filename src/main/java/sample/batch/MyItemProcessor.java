package sample.batch;

import javax.annotation.PostConstruct;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import sample.entity.Test;

/**
 *
 * @author tada
 */
@Named
@Dependent
public class MyItemProcessor implements ItemProcessor {

    @PostConstruct
    public void init() {
        System.out.println("ItemProcessor init.");
    }
    
    @Override
    public Object processItem(Object item) throws Exception {
        String line = (String) item;
        System.out.println("Processor processItem : " + line);
        String[] values = line.split(",");
        int id = Integer.parseInt(values[0]);
        String name = values[1];
        Test test = new Test(id, name);
        return test;
    }
    
}
