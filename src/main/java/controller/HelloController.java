package controller;

import com.jfinal.core.Controller;
import contract.Ballot;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.protocol.parity.methods.response.PersonalListAccounts;
import org.web3j.protocol.parity.methods.response.PersonalUnlockAccount;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by mac on 2017/3/14.
 */
public class HelloController extends Controller {
    public void index() throws ExecutionException, InterruptedException, IOException, CipherException {
        //http://222.20.138.2:58081/
        Web3j web3j = Web3j.build(new HttpService("http://222.20.138.2:58081/"));
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        Parity parity = Parity.build(new HttpService("http://222.20.138.2:58081/"));
        PersonalListAccounts personalListAccounts = parity.personalListAccounts().sendAsync().get();
        for (String id:personalListAccounts.getAccountIds()
             ) {
            System.out.println(id);
        }

        Credentials credentials=WalletUtils.loadCredentials("123456","/Users/mac/Desktop/keystore/UTC--2017-03-13T09-57-30.621103663Z--525f4d4f7bced2570d7962e03faf04e5b859438d");
        System.out.println(credentials.getAddress());
        Ballot ballot = Ballot.load("0x6d5a0f7ab0d3d7ede4f2015d29f86b909578fb77",web3j,credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
        System.out.println(ballot.winningProposal().get().getValue().intValue());
        //System.out.println(Credentials.create("123456").getAddress());
        System.out.println(WalletUtils.getDefaultKeyDirectory());

        System.out.print("");
        /*for (int i = 0; i <parity.personalListAccounts().toString() ; i++) {
            System.out.print(parity.personalListAccounts().getParams().get(i));
        }
        PersonalUnlockAccount personalUnlockAccount = null;
        try {
            personalUnlockAccount = parity.personalUnlockAccount("0x000...", "123456").sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (personalUnlockAccount.accountUnlocked()) {
            // send a transaction, or use parity.personalSignAndSendTransaction() to do it all in one

        }*/
        renderText("test");

    }
}
