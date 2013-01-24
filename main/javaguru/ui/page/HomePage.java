package javaguru.ui.page;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javaguru.app.Wish;
import javaguru.dao.Factory;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage{

	private static final long serialVersionUID = 1L;
	private int wishCount;
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public HomePage(final PageParameters parameters) throws SQLException {
		Collection wishes = Factory.getInstance().getWishDao().getAllWishes();
		Iterator iterator = wishes.iterator();

	    RepeatingView repeat = new RepeatingView("Wish");
	    add(repeat);
	    
	    while (iterator.hasNext()) {
	    	Wish wish = (Wish) iterator.next();
            
            PageParameters pageParameters = new PageParameters();
            
            WebMarkupContainer parent = new WebMarkupContainer(repeat.newChildId());
            repeat.add(parent);
            
            parent.add(new Label("label2", "wish: " + wish.getMyWish()));
        
            parent.add(new Label("label3", "prize: " + wish.getPrice()));
            parent.add(new Label("label4", "Discription: " + wish.getShop()));
            
            setWishCount(getWishCount() + 1);
	    }
	    add(new Label("label5", "Total wish count: " + getWishCount()));

	}

	public int getWishCount() {
		return wishCount;
	}

	public void setWishCount(int wishCount) {
		this.wishCount = wishCount;
	}
	
}
	