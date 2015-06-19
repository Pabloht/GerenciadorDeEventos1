
import util.EntityManagerUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PabloHenrique
 */
public class Main {
    public static void main(String[] args) {
        try {
            EntityManagerUtil.getEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
