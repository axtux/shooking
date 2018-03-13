package be.ac.ulb.infof307.g10.Objects;


public class List {
	
	private String userId;
	private Integer listId;
	private Integer productId;
	private Integer amount;
	
	public List(String UserId, Integer ListId, Integer ProductId){
		userId = UserId;
		listId = ListId;
		productId = ProductId;
	}
	
	public Integer getAmount(){
		return amount;
	}

	public void setAmount(Integer Amount){
		amount = Amount;
	}
}
