/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bytebankers.swing.ui;

import com.bytebankers.contabancaria.ex.ValorTransacionalInvalido;
import com.bytebankers.contabancaria.model.ContaBanco;
import com.bytebankers.swing.http.ClienteHttp;
import com.bytebankers.swing.ui.telas_mensagem.ErroTransacaoNegada;

/**
 *
 * @author sammy
 */
public class TelaMensalidade extends javax.swing.JFrame {
    
    private ContaBanco conta;
    private float taxa;
    
    /**
     * Creates new form Depositar
     */
    public TelaMensalidade(ContaBanco conta) {
        this.conta = conta;
        this.taxa = retornarTaxa(conta.getTipo());
        initComponents();
    }

    /**
     * This method is called from intwithin the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        textoTransacao = new javax.swing.JLabel();
        valorTransacao = new javax.swing.JTextField();
        efeturaTransacao = new javax.swing.JButton();
        currency = new javax.swing.JLabel();
        valorSaldo = new javax.swing.JLabel();
        efeturaTransacao1 = new javax.swing.JButton();
        valorTaxa = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoTransacao.setText("Pagar mensalidade");

        valorTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTransacaoActionPerformed(evt);
            }
        });

        efeturaTransacao.setText("Pagar Mensalidade");
        efeturaTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efeturaTransacaoActionPerformed(evt);
            }
        });

        currency.setText("R$");

        valorSaldo.setText("Saldo atual : " + this.conta.getSaldo());

        efeturaTransacao1.setText("Voltar");
        efeturaTransacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar(evt);
            }
        });

        valorTaxa.setText("Taxa : " + this.taxa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(currency)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(efeturaTransacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorTransacao)
                    .addComponent(valorSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(efeturaTransacao1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorTaxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(textoTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(textoTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currency))
                .addGap(26, 26, 26)
                .addComponent(efeturaTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(efeturaTransacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valorSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void valorTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTransacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTransacaoActionPerformed

    private void efeturaTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efeturaTransacaoActionPerformed
        ContaBanco contaN = this.conta;
        boolean ocorreuErro = false;

        try{
            contaN.pagarMensalidade(Float.parseFloat(valorTransacao.getText()));
            contaN = ClienteHttp.salvarAlteracoes(conta);
        }catch(ValorTransacionalInvalido e){
            ocorreuErro = true;
        }
        
        if(ocorreuErro){
            this.dispose();
            new ErroTransacaoNegada(this.conta).setVisible(true);
        }else{
            this.dispose();
            new TelaPrincipal(contaN).setVisible(true);
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_efeturaTransacaoActionPerformed

    private void voltar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar
        // TODO add your handling code here:
        this.dispose();
        new TelaPrincipal(this.conta).setVisible(true);
    }//GEN-LAST:event_voltar

    private float retornarTaxa(String tipo){
        if(tipo.equals("CC")){
            return 12f;
        }else{
            return 20f;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currency;
    private javax.swing.JButton efeturaTransacao;
    private javax.swing.JButton efeturaTransacao1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel textoTransacao;
    private javax.swing.JLabel valorSaldo;
    private javax.swing.JLabel valorTaxa;
    private javax.swing.JTextField valorTransacao;
    // End of variables declaration//GEN-END:variables
}
