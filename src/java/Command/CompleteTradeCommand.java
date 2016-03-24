/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Daos.*;
import Dtos.Trade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Arc
 */
public class CompleteTradeCommand implements CommandInterface {

    /**
     * This command is used to complete the trade and then pay the sender of the game.
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to trade.jsp, the barterServlet uses the trade command again to update session variables.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //Mark trade as complete and send money from GameHub to sender.
        String forwardToJsp = "BarterServlet?action=trade";
        int tradeId = Integer.parseInt(request.getParameter("tradeId"));
        TradeDao tradeDao = new TradeDao();
        
        //Find and complete trade.
        Trade trade = tradeDao.viewTradeById(tradeId);
        tradeDao.completeTrade(trade);
        
        return forwardToJsp;
    }
}
