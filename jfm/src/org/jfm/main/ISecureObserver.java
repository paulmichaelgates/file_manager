package org.jfm.main;

/*
 * SER335 LAB6
 */
public interface ISecureObserver {
    /*
     * We only have the single use case for this now
     * so may as well make the contract direct and
     * pass the user
     */
    public void update( String userName, String password, String role );
}
