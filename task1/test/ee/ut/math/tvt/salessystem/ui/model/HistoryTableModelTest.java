package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class HistoryTableModelTest {
	 
    HistoryItem historyItem;
    HistoryTableModel htm;
    
    @Before
    public void setUp() throws Exception {
            List<SoldItem> goods = new ArrayList<SoldItem>();
            
            goods.add(new SoldItem(new StockItem((long) 6 , "beer", 3.40, 50), 10));
            goods.add(new SoldItem(new StockItem((long) 7, "vesi", 1.50, 10), 6));
           
            historyItem = new HistoryItem(goods);
            htm = new HistoryTableModel();
            htm.addItem(historyItem);
    }
    
    @Test
    public void testAddItem() {
            assertEquals(historyItem.getDate(), htm.getTableRows().get(0).getDate());
            assertEquals(historyItem.getTime(), htm.getTableRows().get(0).getTime());   
            assertEquals(historyItem.getPrice(), htm.getTableRows().get(0).getPrice(), 0.0001); 
    }
    
    @Test
    public void testGetColumnValue() {
            assertEquals(historyItem.getDate(), htm.getColumnValue(historyItem, 1));
            assertEquals(historyItem.getTime(), htm.getColumnValue(historyItem, 2));
            assertEquals(historyItem.getPrice(), (Double) htm.getColumnValue(historyItem, 3), 0.0001);
            
    }

}
