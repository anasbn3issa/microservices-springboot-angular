const express = require("express");
const {
    getAllPets,
    getPetById,
    createPet,
    updatePet,
    deletePet
} = require("../api/pet");
const router = express.Router();

router.get("/", getAllPets);
router.get("/:id", getPetById);
router.post("/", createPet);
router.put("/:id", updatePet);
router.delete("/:id", deletePet);

module.exports = router;