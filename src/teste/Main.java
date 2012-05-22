package teste;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import planilhaMetodos.Comunicacao;
import planilhaMetodos.CopiarArquivo;
import planilhaMetodos.MovendoAqruivo;

@ManagedBean
@SessionScoped
public class Main {

	public int flag = 1;
	/**
	 * @param args
	 */
	public void vai() {
		
		Comunicacao comunica = new Comunicacao();
		CopiarArquivo copy = new CopiarArquivo();
		MovendoAqruivo move = new MovendoAqruivo();
		
		String dado;
//		int posX, posY;
		int i, linha = 6, coluna = 4; 
		
		int tamanho = 3;
		
		flag = Integer.parseInt( JOptionPane.showInputDialog(null,"Opção"));
		
		if( flag == 1 ){

//			posX = Integer.parseInt( JOptionPane.showInputDialog(null,"Posição X da celula:"));
//			posY = Integer.parseInt( JOptionPane.showInputDialog(null,"Posição Y da celula:"));
//			comunica.metodos("escrever", posX, posY, dado);
			
			linha = 6;
			coluna = 4; 
			
			for( i=linha; i<=linha+68; i++ ){
				//dado = JOptionPane.showInputDialog(null,"Digite o dado para armazenar na celula " + i+1 +":");
				dado = "not supported";
				comunica.metodos("escrever", coluna, i, dado);
				System.out.println("Linha: " + i);
				if( i == 31 ){
					i = 35;
				}
			}
			
			System.out.println("fim");
			
//			for(int i = 0; i<tamanho; i++){
//				for(int j = 0; j<tamanho; j++){
//					//dado = JOptionPane.showInputDialog(null,"Digite o dado para armazenar na celula:");
//					comunica.metodos("escrever", 0, 0, "");
//				}
//			}
		}
		else if( flag == 2 ){
			
//			posX = Integer.parseInt( JOptionPane.showInputDialog(null,"Posição X da celula:"));
//			posY = Integer.parseInt( JOptionPane.showInputDialog(null,"Posição Y da celula:"));
//			comunica.metodos("ler", posX, posY,"");
			
			for( i = 0; i<tamanho; i++){
				for(int j = 0; j<tamanho; j++){
					comunica.metodos("ler", i, j,"");
				}
			}
		}
		else if( flag == 3 ){
			
			// Linhas e Colunas eh uma a menos que o valor mostrado na planilha
			// Devem ser enviadas de forma trocada (coluna,linha)
			linha = 35;
			coluna = 6;
			
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			
			String imagem = request.getSession().getServletContext().getRealPath("/");			
			imagem = imagem + "planilha\\imagens\\";
			
			// Insere a imagem do Central Painel
			comunica.metodos("inserir imagem", imagem+"1.png", coluna, linha, 2, 1);
			
			linha = linha + 2;
			// Insere a imagem do icone do App Store
			comunica.metodos("inserir imagem", imagem+"1.png", coluna, linha, 2, 1);
			
			linha = linha + 8;
			// Insere as 7 imagens das aplicações do App Store
			int cont=2;
			for(i=coluna; i<coluna+7; i++ ){
				comunica.metodos("inserir imagem", imagem+cont+".png", i, linha, 1, 1);
				cont++;
			}
			
			linha = linha + 7;
			// Insere a imagem do icone do Google Search
			comunica.metodos("inserir imagem", imagem+"1.png", coluna, linha, 2, 1);
			
			System.out.println("fim");
		}
		else if( flag == 4 ){
			
			comunica.metodos("remover imagem", 2, 2,"");
		}
		else if( flag == 5 ){
			
			move.mover();
			try {
				copy.copiar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro ao tentar copiar o arquivo.");
			}
		}
	}

}
