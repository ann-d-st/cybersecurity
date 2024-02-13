- can encrypt BCrypt, check password, do not recommend
- top 10000 most common passwords can be checked
- MD5 hashed passwords can be checked (without salt)
- SHA 256 passwords can be checked (without salt)
- can brute force, do not recommend
- dictionary can be checked (dictionary attack)
- can take command line arguments

basic format for running program in terminal: "java [filename].java [command]" 

files/types of attacks:
- BCrypt
    commands:
        --break : runs program (note: time complications)
        --setPass : sets a new correct password depending on user input
        --enc : outputs encrypted user input
- BruteForce
    commands:
        just run it normally, no commands added
- CommonPasswords
    commands:
        --break : runs program
        --setPass : sets a new correct password depending on user input
- DictionaryAttack
    commands:
        --break : runs program
        --setPass : sets a new correct password depending on user input
- MD5
    commands:
        --break : runs program
        --setPass : sets a new correct password depending on user input
        --enc : outputs encrypted user input
-SHA
    commands:
        --break : runs program
        --setPass : sets a new correct password depending on user input
        --enc : outputs encrypted user input
        --encsa : outputs encrypted user input with salt

reminder: add commands following basic format. MUST use a command. if not, program will not work

