package org.BancoBlueMoon;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.Desktop;

public class Fatura {

    public static void gerarFaturaPDF(Cliente cliente, ContaBancaria conta) {
        Document document = new Document();
        try {
            // Define o caminho do arquivo PDF
            String caminhoArquivo = "Fatura_" + cliente.getNome().replace(" ", "_") + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Inserir logo no documento
            String caminhoLogo = "logo.png"; // Caminho para o logo
            Image logo = Image.getInstance("file:" + caminhoLogo); // Corrigido com prefixo 'file:'
            logo.scaleToFit(100, 100); // Ajusta o tamanho do logo
            logo.setAlignment(Element.ALIGN_CENTER); // Alinha ao centro
            document.add(logo); // Adiciona o logo ao documento

            // Adiciona título ao documento
            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph titulo = new Paragraph("Fatura - Banco BlueMoon\n\n", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            // Adiciona os dados do cliente
            Font dadosFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            document.add(new Paragraph("Nome: " + cliente.getNome(), dadosFont));
            document.add(new Paragraph("CPF: " + cliente.getCpf(), dadosFont));
            document.add(new Paragraph("E-mail: " + cliente.getEmail(), dadosFont));
            document.add(new Paragraph("Endereço: " + cliente.getEndereco(), dadosFont));
            document.add(new Paragraph("\n---------------------------------------------\n", dadosFont));

            // Adiciona saldo da conta
            document.add(new Paragraph("💰 Saldo da Conta: R$ " + String.format("%.2f", conta.getSaldo()), dadosFont));

            // Adiciona fatura do cartão de crédito
            document.add(new Paragraph("💳 Fatura do Cartão de Crédito: R$ " + String.format("%.2f", conta.getFaturaCartaoCredito()), dadosFont));

            // Mensagem final
            document.add(new Paragraph("\nObrigado por utilizar o Banco BlueMoon!", dadosFont));

            // Fecha o documento
            document.close();

            // Exibe mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Fatura gerada com sucesso!\nArquivo: " + caminhoArquivo,
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Abre automaticamente o arquivo PDF após gerar
            abrirArquivoPDF(caminhoArquivo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar fatura: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para abrir automaticamente o PDF
    private static void abrirArquivoPDF(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            if (arquivo.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(arquivo);
                } else {
                    JOptionPane.showMessageDialog(null, "Desktop não suportado.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
