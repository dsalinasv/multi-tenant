/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.util;

public class TenantContextHolder {

    private static final String DEFAULT_TENANT_ID = "DATABASE_URL";

    private static final ThreadLocal<String> CONTEXT
            = new ThreadLocal<String>() {
        @Override
        public String initialValue() {
            return DEFAULT_TENANT_ID;
        }
    };

    public static void setTenantId(String tenant) {
        CONTEXT.set(tenant);
    }

    public static String getTenant() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }

}
