package sample.batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tada
 */
@Named
@Dependent
public class MyItemReader implements ItemReader {

    @Inject
    private JobContext jobContext;
    
    private BufferedReader br;
    
    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("ItemReader open.");
        String path = System.getProperty("user.dir");
        System.out.println(path);
        String dirName = jobContext.getProperties().getProperty("dir");
        String fileName = jobContext.getProperties().getProperty("input_file");
        br = Files.newBufferedReader(Paths.get(dirName, fileName), StandardCharsets.UTF_8);
    }

    @Override
    public void close() throws Exception {
        System.out.println("ItemReader close.");
        
        br.close();
    }

    @Override
    public Object readItem() throws Exception {
        String data = br.readLine();
        System.out.println("Reader readItem : " + data);
        return data;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        System.out.println("ItemReader checkpoint.");
        return null;
    }
    
}
