package sample.batch;

import java.io.Serializable;
import java.util.List;
import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author tada
 */
@Named
@Dependent
public class MyItemWriter implements ItemWriter {

    @Inject
    private JobContext jobContext;
    
    @Inject
    private EntityManager em;
    
    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("ItemWriter open.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("ItemWriter close.");
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        System.out.println("ItemWriter writeItem : " + items);
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        System.out.println("ItemWriter checkpoint.");
        return null;
    }
    
}
