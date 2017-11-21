package edu.asselvi.item.itemSolicEstoque.itemCotacao;

import edu.asselvi.item.itemSolicEstoque.ItemSolicEstoque;

public class ItemCotacao extends ItemSolicEstoque {
	private int cdItemCotacao;
	private long qtItemCotacao;
	private int nrCotacao;

	public ItemCotacao() {
		super();
	}

	public ItemCotacao(int cdItem, String dsItem, int cdItemEstoque, long qtItem, int cdFornecedor, int cdItemCotacao,
			long qtItemCotacao, int nrCotacao) {
		super(cdItem, dsItem, cdItemEstoque, qtItem, cdFornecedor);
		this.cdItemCotacao = cdItemCotacao;
		this.qtItemCotacao = qtItemCotacao;
		this.nrCotacao = nrCotacao;
	}

	public int getCdItemCotacao() {
		return cdItemCotacao;
	}

	public void setCdItemCotacao(int cdItemCotacao) {
		this.cdItemCotacao = cdItemCotacao;
	}

	public long getQtItemCotacao() {
		return qtItemCotacao;
	}

	public void setQtItemCotacao(long qtItemCotacao) {
		this.qtItemCotacao = qtItemCotacao;
	}

	public int getNrCotacao() {
		return nrCotacao;
	}

	public void setNrCotacao(int nrCotacao) {
		this.nrCotacao = nrCotacao;
	}

	@Override
	public String toString() {
		return "Item da Cotacao "
				+ "\n Código = " + getCdItemCotacao() 
				+ "\n Item = " + getDsItem()
				+ "\n Cotação = " + getNrCotacao() + "]";
	}

	
}
