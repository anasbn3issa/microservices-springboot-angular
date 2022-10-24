const mongoose = require("mongoose");

const petSchema = mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
        },
        type: {
            type: String,
            required: true,
        },
        race: {
            type: String,
            required: true,
        },
        age: {
            type: Number,
            required: true,
        },
        captureDate: {
            type: Date,
        },
    }
    , { timestamps: true }
);

module.exports = mongoose.model("Pet", petSchema);
