package javaguru.ui.page;

import java.sql.SQLException;

import javaguru.app.Wish;
import javaguru.dao.Factory;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CoursePage extends WebPage {
	private static final long serialVersionUID = 1L;
	public String message1 ="Enter ID";
	public String message2="Enter Wish";
	public String message3 = "Enter Price";
	public String message4= "Enter Shop";

    public CoursePage(final PageParameters parameters) {
	      
		PropertyModel<String> messageModel1 = new PropertyModel<String>(this, "message1");

		PropertyModel<String> messageModel2 = new PropertyModel<String>(this, "message2");
	
		PropertyModel<String> messageModel3 = new PropertyModel<String>(this, "message3");

		PropertyModel<String> messageModel4 = new PropertyModel<String>(this, "message4");

		Form<?> form = new Form("form");
      form.add(new TextField<String>("msgInput1", messageModel1));
      form.add(new TextField<String>("msgInput2", messageModel2));
      form.add(new TextField<String>("msgInput3", messageModel3));
      form.add(new TextField<String>("msgInput4", messageModel4));
      add(form);

      
          form.add(new AjaxButton("ajax-button", form){
        	  protected void onSubmit(AjaxRequestTarget target, Form<?> form)
              {
        		  int buf = Integer.parseInt(getMessage2());
                  // repaint the feedback panel so that it is hidden
        	      Wish wish = new Wish();
        	      wish.setWID( buf);
        	      wish.setMyWish(getMessage2());
        	      wish.setPrice(getMessage3());
        	      wish.setShop(getMessage4());
      	        try {
    	     		Factory.getInstance().getWishDao().addWish(wish);
    	     		
    	     	} catch (SQLException e) {
    	     		// TODO Auto-generated catch block
    	     		e.printStackTrace();
    	     	}
              }    
          });
          
    }
    public void setMessage1(String message)
    {
        this.message1 = message;
    }
    public String getMessage1()
    {
        return message1;
    }
    public String getMessage2()
    {
        return message2;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage2(String message)
    {
        this.message2 = message;
    }
    public String getMessage3()
    {
        return message3;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage3(String message)
    {
        this.message3 = message;
    }
    public String getMessage4()
    {
        return message4;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage4(String message)
    {
        this.message4 = message;
    }
}
