/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;


/**
 *
 * @author tim
 */
@WebServlet(urlPatterns = {"/Notification"})
public class Notification extends HttpServlet {
public String SERVER_KEY_FCM = "AAAASHOgsuU:APA91bGeVkEOn8fRTV4JeeRu6nPwqbCrVeZwNzjryShlaSc5dmXBj6m9NxhLFduhEy_A9F14gzF4LKPV4YELAa97fgi_zgI9oYyXDb7Uuj07_DPQMuDK2pUbE5b8Q6cBOIbuchAkJqEk";



/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         System.out.print("GET");   

//yourshithere
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
//        String DeviceIdKey = deviceId;
        URL url = new URL(API_URL_FCM);
        HttpURLConnection connfcm = (HttpURLConnection) url.openConnection();
        
        connfcm.setUseCaches(false);
        connfcm.setDoInput(true);
        connfcm.setDoOutput(true);
        connfcm.setRequestMethod("POST");
        connfcm.setRequestProperty("Authorization", "key="+SERVER_KEY_FCM);
        connfcm.setRequestProperty("Content-Type", "application/json");

       
      
        
        JSONObject body = new JSONObject();
        JSONObject data =  new  JSONObject();
        JSONObject notification = new JSONObject();
        
        body.put("to","eyuuEvZFzrA:APA91bE7V_TboJskxgrgsxMLsr0pTuaBTYUy0ACNf48mNmYNbj9BPlS4HTLzav5eRrJsYOczxEFSK7UTvP2UCSbOaGvXCkmfECgPYtB8NU04BAH7wdutUBrEj2n-D8uxiZyBOaioJ2JC");
        notification.put("title", "FCM Message");
        notification.put("body", "This is an FCM Message");
        data.put("notification", notification);
        body.put("message", data);
        
//        obj.put("num",new Integer(100));
//        obj.put("balance",new Double(1000.21));
//        obj.put("is_vip",new Boolean(true));
        OutputStreamWriter out = new OutputStreamWriter(connfcm.getOutputStream());
        
        
        out.write(body.toJSONString());
        out.flush();
        out.close();
        int respondcodeObj = connfcm.getResponseCode();
        System.out.println(respondcodeObj);
        System.out.println(out);
        
     
//            PrintWriter out = new PrintWriter();

        //obj.writeJSONString(out);

        String jsonText = out.toString();
//        System.out.print("POST");   

        
//            JSONObject obj = new JSONObject();
//
//            obj.put("Token","foo");
//            obj.put("num",new Integer(100));
//            obj.put("balance",new Double(1000.21));
//            obj.put("is_vip",new Boolean(true));
//
//            StringWriter out = new StringWriter();
//            obj.writeJSONString(out);
//            
//            String jsonText = out.toString();
//            System.out.print(jsonText);            
            //yourshithere
    }

}
