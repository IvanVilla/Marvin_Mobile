package persistance;

/**
 * Created by boscalent on 04/11/2016.
 */
public interface DAO {
    public void setup() throws Exception;
    public void connect() throws Exception;
    public void close() throws Exception;
}
