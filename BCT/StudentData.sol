// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {

    // Structure for student details
    struct Student {
        uint rollNo;
        string name;
        uint marks;
    }

    // Dynamic array to store student records
    Student[] public students;

    // Function to add a new student
    function addStudent(uint _rollNo, string memory _name, uint _marks) public {
        students.push(Student(_rollNo, _name, _marks));
    }

    // Function to get total number of students
    function getStudentCount() public view returns (uint) {
        return students.length;
    }

    // Function to get details of a student by index
    function getStudent(uint index) public view returns (uint, string memory, uint) {
        require(index < students.length, "Invalid index");
        Student memory s = students[index];
        return (s.rollNo, s.name, s.marks);
    }

    // Fallback function to handle Ether transactions or wrong calls
    fallback() external payable {}

    // Function to check contract balance
    function getContractBalance() public view returns (uint) {
        return address(this).balance;
    }
}
