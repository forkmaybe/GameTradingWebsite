/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Trade;
import java.util.List;

/**
 *
 * @author Arc
 */
public interface TradeDaoInterface {

    /**
     * Interface for addTrade.
     *
     * @param newTrade 
     */
    public void addTrade(Trade newTrade);

    /**
     * Interface for viewAllTrades();
     *
     * @return
     */
    public List<Trade> viewAllTrades();

    /**
     * Interface for viewTradeById(int compTradeId);
     *
     * @param compTradeId
     * @return
     */
    public Trade viewTradeById(int compTradeId);

    /**
     * Interface for completeTrade(Trade compTrade)
     *
     * @param compTrade
     */
    public void completeTrade(Trade compTrade);
}
