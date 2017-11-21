package edu.asselvi.item;

public class Item {
	private int cdItem;
	private String dsItem;

	public Item() {
		setCdItem(0);
		setDsItem("");
	}

	public Item(int cdItem, String dsItem) {
		super();
		this.cdItem = cdItem;
		this.dsItem = dsItem;
	}

	public int getCdItem() {
		return cdItem;
	}

	public void setCdItem(int cdItem) {
		this.cdItem = cdItem;
	}

	public String getDsItem() {
		return dsItem;
	}

	public void setDsItem(String dsItem) {
		this.dsItem = dsItem;
	}


	@Override
	public String toString() {
		return "Item [Código ="	+ getCdItem() 
				+ "\n Descrição=" + getDsItem() + "]";
	}
	
	
}
