package contract;

import java.lang.String;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.0.1.
 */
public final class Ballot extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b60405160208061048783398101604052515b60008054600160a060020a03191633600160a060020a03908116919091178083551681526001602081905260409091205560ff811661005e600282610066565b505b506100b1565b81548183558181151161008a5760008381526020902061008a918101908301610090565b5b505050565b6100ae91905b808211156100aa5760008155600101610096565b5090565b90565b6103c7806100c06000396000f300606060405263ffffffff60e060020a6000350416635c19a95c8114610042578063609ff1bd146100605780639e7b8d6114610086578063b3f98adc146100a4575bfe5b341561004a57fe5b61005e600160a060020a03600435166100bc565b005b341561006857fe5b610070610238565b6040805160ff9092168252519081900360200190f35b341561008e57fe5b61005e600160a060020a03600435166102aa565b005b34156100ac57fe5b61005e60ff6004351661030e565b005b600160a060020a033316600090815260016020819052604082209081015490919060ff16156100ea57610232565b5b600160a060020a038381166000908152600160208190526040909120015462010000900416158015906101475750600160a060020a03838116600090815260016020819052604090912001546201000090048116339190911614155b1561017957600160a060020a0392831660009081526001602081905260409091200154620100009004909216916100eb565b33600160a060020a031683600160a060020a0316141561019857610232565b506001818101805460ff1916821775ffffffffffffffffffffffffffffffffffffffff0000191662010000600160a060020a0386169081029190911790915560009081526020829052604090209081015460ff161561022a5781546001820154600280549091610100900460ff1690811061020f57fe5b906000526020600020900160005b5080549091019055610232565b815481540181555b5b505050565b600080805b60025460ff821610156102a4578160028260ff1681548110151561025d57fe5b906000526020600020900160005b5054111561029b576002805460ff831690811061028457fe5b906000526020600020900160005b50549092509050815b5b60010161023d565b5b505090565b60005433600160a060020a0390811691161415806102e45750600160a060020a0381166000908152600160208190526040909120015460ff165b156102ee5761030b565b600160a060020a0381166000908152600160208190526040909120555b50565b600160a060020a03331660009081526001602081905260409091209081015460ff1680610340575060025460ff831610155b1561034a57610397565b6001818101805460ff191690911761ff00191661010060ff85169081029190911790915581546002805491929091811061038057fe5b906000526020600020900160005b50805490910190555b50505600a165627a7a72305820caac45d42b809807a8fbe92a916c751a28494cec7330c71cad8b51a25da09e030029";

    private Ballot(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private Ballot(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<TransactionReceipt> delegate(Address to) {
        Function function = new Function("delegate", Arrays.<Type>asList(to), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint8> winningProposal() {
        Function function = new Function("winningProposal", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> giveRightToVote(Address voter) {
        Function function = new Function("giveRightToVote", Arrays.<Type>asList(voter), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> vote(Uint8 proposal) {
        Function function = new Function("vote", Arrays.<Type>asList(proposal), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<Ballot> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue, Uint8 _numProposals) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_numProposals));
        return deployAsync(Ballot.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialValue);
    }

    public static Future<Ballot> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue, Uint8 _numProposals) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_numProposals));
        return deployAsync(Ballot.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialValue);
    }

    public static Ballot load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ballot(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Ballot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ballot(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
