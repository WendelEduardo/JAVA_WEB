package br.fiap.avl;

import br.fiap.cliente.Cliente;

public class AVL {
	private class ARVORE {
		Cliente dado;
		ARVORE dir;
		ARVORE esq;
		int hEsq;
		int hDir;
	}

	public ARVORE root = null;

	public ARVORE inserirAVL(ARVORE p, Cliente info) {
		if (p == null) { // nó inserido sempre será nó folha
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
			p.hDir = 0;
			p.hEsq = 0;
		} else if (p.dado > info) {
			p.esq = inserirAVL(p.esq, info);
			if (p.esq.hDir > p.esq.hEsq) // Altura do nó será a maior
				p.hEsq = p.esq.hDir + 1; // altura dos seus filhos
			else
				p.hEsq = p.esq.hEsq + 1;
			p = balanceamento(p);
		} else {
			p.dir = inserirAVL(p.dir, info);
			if (p.dir.hDir > p.dir.hEsq)
				p.hDir = p.dir.hDir + 1;
			else
				p.hDir = p.dir.hEsq + 1;
		}
		p = balanceamento(p);
		return p;
	}

	public ARVORE balanceamento(ARVORE p) {
		// analisa FB e realiza rotações necessárias para balancear árvore
		int FB = p.hDir - p.hEsq;
		if (FB > 1) {
			int fbFilhoDir = p.dir.hDir - p.dir.hEsq;
			if (fbFilhoDir >= 0)
				p = rotacaoEsquerda(p);
			else {
				p.dir = rotacaoDireita(p.dir);
				p = rotacaoEsquerda(p);
			}
		} else {
			if (FB < -1) {
				int fbFilhoEsq = p.esq.hDir - p.esq.hEsq;
				if (fbFilhoEsq <= 0)
					p = rotacaoDireita(p);
				else {
					p.esq = rotacaoEsquerda(p.esq);
					p = rotacaoDireita(p);
				}
			}
		}
		return p;
	}

	public ARVORE rotacaoDireita(ARVORE p) {
		// faz rotação para direita em relação ao nó apontado por p
		ARVORE q, temp;
		q = p.esq;
		temp = q.dir;
		q.dir = p;
		p.esq = temp;
		return q;
	}

	public ARVORE rotacaoEsquerda(ARVORE p) {
		// faz rotação para esquerda em relação ao nó apontado por p
		ARVORE q, temp;
		q = p.dir;
		temp = q.esq;
		q.esq = p;
		p.dir = temp;
		return q;
	}

	public void atualizaAlturas(ARVORE p) {
		/*
		 * atualiza informação da altura de cada nó depois da remoção percorre a árvore
		 * usando percurso pós-ordem para ajustar primeiro os nós folhas (profundidade
		 * maior) e depois os níveis acima
		 */
		if (p != null) {
			atualizaAlturas(p.esq);
			if (p.esq == null)
				p.hEsq = 0;
			else if (p.esq.hEsq > p.esq.hDir)
				p.hEsq = p.esq.hEsq + 1;
			else
				p.hEsq = p.esq.hDir + 1;
			atualizaAlturas(p.dir);
			if (p.dir == null)
				p.hDir = 0;
			else if (p.dir.hEsq > p.dir.hDir)
				p.hDir = p.dir.hEsq + 1;
			else
				p.hDir = p.dir.hDir + 1;
		}
	}

	public void mostraFB(ARVORE p) {
		if (p != null) {
			mostraFB(p.esq);
			mostraFB(p.dir);
			System.out.println("\t Dado: " + p.dado + " \t FB: " + (p.hDir - p.hEsq));
		}
	}
}
