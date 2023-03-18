package com.movielibrary.demo.client.internal;

import com.movielibrary.demo.client.api.Client;
import com.movielibrary.demo.client.api.ClientNotFoundException;
import com.movielibrary.demo.client.api.WrongEmailAddressFormatException;
import com.movielibrary.demo.client.api.WrongPeselFormatException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Slf4j
@AllArgsConstructor
public class ClientServiceImpl {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients(){
        List<Client> clientList = clientRepository.findAll();
        return validateList(clientList);
    }

    public Client getClientById(Long id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()) {
            throw new ClientNotFoundException(id);
        }
        return clientOptional.get();
    }

    public void addNewClient(Client client){
        if(!validateStringAsCorrectEmailAddress(client.getContactEmail())){
            throw new WrongEmailAddressFormatException("You use not allowed email address format");
        }
        if(!validateStringAsCorrectPesel(client.getPeselNumber())){
            throw new WrongPeselFormatException("You use not allowed pesel format");
        }

    }



    /**Generic method to check if our List is empty and will throw unwanted
     * NullPointerException. Accept List which is possible empty,
     * if it is empty throw exception, if is not return list.
     * @param list
     * @return verified list with emails.
     */
    private <T>List<T> validateList(List<T> list) {
        if(list.isEmpty())
            throw new ClientNotFoundException("There's no Clients in Database");
        return list;
    }

    /** Method to check if our string that represent email address
     * has correct format.
     * @param email
     * @return true if string included email address is correct, otherwise false.
     */
    private boolean validateStringAsCorrectEmailAddress(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        return Pattern.compile(regex)
                .matcher(email)
                .matches();
    }

    /** Method to check if our string that represent PESEL
     * has correct length.
     * @param peselNumber
     * @return true if string included email address is correct, otherwise false.
     */
    private boolean validateStringAsCorrectPesel(String peselNumber) {
        String regex = "^[0-9]{11}$";
        return Pattern.compile(regex)
                .matcher(peselNumber)
                .matches();
    }
}
