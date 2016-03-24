
package Exception;

import java.sql.SQLException;

/**
 *
 * @author d00133633
 */
public class DaoException extends SQLException {

    /**
     *blank for default use
     */
    public DaoException() {
    }

    /**
     *when there is a dao exception it runs this constuctor which runs sql exception and that runs exception
     * @param aMessage is passed in with details of the exception
     */
    public DaoException(String aMessage) {
        super(aMessage);
    }
}
