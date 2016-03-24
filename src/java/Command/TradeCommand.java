/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Command;

import Daos.TradeDao;
import Dtos.Trade;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author d00135791
 */
public class TradeCommand implements CommandInterface {

    /**
     * This command is used to trade to complete the trade with some
     * shows a list off your active trades with some and if the the 
     * trade is complete and both ends you then complete the trade
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to trades.jsp.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String forwardToJsp = "trades.jsp";
        String message = "Welcome to Trades!";
        TradeDao tradeDao = new TradeDao();
        HttpSession session = request.getSession();
        List<Trade> tradeList;
        try {
            tradeList = tradeDao.viewAllTrades();
            if (tradeList != null) {
                session.setAttribute("tradeList", tradeList);
            } else {
                message = "Trades not loaded.";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        session.setAttribute("tradesMessage", message);
        return forwardToJsp;
        
    }
}
