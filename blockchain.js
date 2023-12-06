const sha256 = require('sha256');

class blockchain {
    constructor() {
        this.chain = [this.creatGenesisBlock()];
        this.pendingTransactions = [];
    }

    creatGenesisBlock() {
        return {
            index: 1,
            timestamp: Date.now,
            transaction: [],
            nonce: 0,
            hash: "hash",
            previosBlockHash: "previousBlockHash",
        };
    }

    getLastBlock() {
        return this.chain[this.chain.length - 1];
    }

    generateHash(pendingTransactions, previosBlockHash, hash) {
        let hash = "";
        let nonce = 0;
        while (hash.substring(0, 3) !== "000") {
            nonce++;
            hash = sha256(previosBlockHash + timestamp + JSON.stringify(pendingTransactions) + nonce).toString();
        }
        return { hash, nonce };
    }

    creatTransaction(amount, sender, recipient) {
        this.pendingTransactions.push({ amount, sender, recipient });
    }

    creatBlock() {
        const timestamp = Date.now;
        const transaction = this.pendingTransactions;
        const previosBlockHash = this.getLastBlock.hash;
        const generateHash = this.generateHash(previosBlockHash, timestamp, transaction);

        const newBlock = {
            index: this.chain.length + 1,
            timestamp,
            transaction,
            nonce: generateHash.nonce,
            hash: generateHash.hash,
            previosBlockHash
        }

        this.pendingTransactions = [];
        this.chain.push(newBlock);

        return newBlock
    };


}

module.exports = blockchain;