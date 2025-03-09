package org.BancoBlueMoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Endereco {

    public static String buscarEndereco(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpURLConnection conexao = (HttpURLConnection) new URL(url).openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }
            leitor.close();

            JSONObject json = new JSONObject(resposta.toString());

            if (json.has("erro")) {
                return null;
            }

            return "   - CEP: " + json.getString("cep") +
                    "\n   - Rua: " + json.optString("logradouro", "Não informado") +
                    "\n   - Bairro: " + json.optString("bairro", "Não informado") +
                    "\n   - Cidade: " + json.getString("localidade") +
                    "\n   - Estado: " + json.getString("uf");

        } catch (Exception e) {
            return null;
        }
    }
}


