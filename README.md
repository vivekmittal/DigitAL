DigitAL
=======

<b><i>Demostration of Fluent interfaces / TDD / Functional idioms applied with OOPS</i></b>

A simple application to parse digits (from Pipes and underscores) and display the digit/number formed by the digit.

The application will take a input stream (can be a file) having Raw Account Numbers (probably read from a digital machine) formed by pipes and underscores, with one account number on each line.

Each entry in the file is 4 lines long, and each line has 27 characters. The first 3 lines of each entry contain an account number written using pipes and underscores, and the fourth line is blank. Each account number should have 9 digits, all of which should be in the range 0-9. A normal file contains around 500 entries.

VALID / INVALID:
-------
  Any digit which can't be interpreted will be replaced by a question mark '?' and will become invalid<br />
  Checksum of each account number should be divisible by 11 (account is valid if <i>checksum % 11 == 0</i>)
<pre>
      account number:  3  4  5  8  8  2  8  6  5
      position names:  d9 d8 d7 d6 d5 d4 d3 d2 d1

      checksum calculation: (d1+2*d2+3*d3 +..+9*d9)
</pre>

USAGE:
-------
<pre>
    final String FILE_NAME = "data.txt";
    File dataFile = new FileInputStream(FILE_NAME);
    
    for (Account account : Accounts.from(dataFile)) {
        System.out.printf(
                "Account Number: %s, %s \n", 
                            account.getAccountNumber(), 
                            account.isValid() ? "VALID" : "INVALID"
        );
    }
</pre>

TEST:
-------
<pre>
    String rawAccountNumbers =
                  "    _  _     _  _  _  _  _ \n" +
                  "  | _| _||_||_ |_   ||_||_|\n\r" +
                  "  ||_  _|  | _||_|  ||_| _|\n\r" +
                  "                           \n" +
                  "    _  _  _  _  _  _  _  _ \n" +
                  "  | _| _||_ |_ |_   ||_|| |\n\r" +
                  "  | _| _| _||_||_|  ||_||_|\n\r" +
                  "                           ";
    
    Collection<Account> accounts = Accounts.from(new ByteArrayInputStream(rawAccountNumbers.getBytes()));
    
    assertThat(accounts, hasAccountsInOrder("123456789", "133566780"));
</pre>

MORE DETAILS:
-------
This is a implementation of first two stories of the code kata hosted at http://codingdojo.org/cgi-bin/index.pl?KataBankOCR<br />
Please visit the link for more details
