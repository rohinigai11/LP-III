// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount {

    mapping(address => uint) public balances;

    // Function to deposit money
    function deposit() public payable {
        balances[msg.sender] += msg.value;
    }

    // Function to withdraw money
    function withdraw(uint amount) public {
        require(balances[msg.sender] >= amount, "Insufficient balance");
        balances[msg.sender] -= amount;
        payable(msg.sender).transfer(amount);
    }

    // Function to show account balance
    function showBalance() public view returns (uint) {
        return balances[msg.sender];
    }
}
