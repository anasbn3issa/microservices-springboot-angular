const asyncHandler = require("express-async-handler");
const Pet = require("../model/pet");

const getAllPets = asyncHandler(async (req, res) => {
  const pets = await Pet.find({});
  res.json(pets);
});

const getPetById = asyncHandler(async (req, res) => {
  const pet = await Pet.findById(req.params.id);
  if (pet) {
    res.json(pet);
  } else {
    res.status(404);
    throw new Error("Pet not found");
  }
});

const createPet = asyncHandler(async (req, res) => {
  const body = req.body;
  const pet = new Pet(body);
  const createdPet = await pet.save();
  res.status(201).json(createdPet);
});

const updatePet = asyncHandler(async (req, res) => {
  const { name, type, race, age, captureDate } = req.body;
  console.log(req.body);
  await Pet.findByIdAndUpdate(
    req.params.id,
    req.body  );
    res.status(200).json({ message: "Pet updated" });
});


const deletePet = asyncHandler(async (req, res) => {
    await Pet.findByIdAndDelete(req.params.id);
    res.status(204).end();
});

module.exports = {
    getAllPets,
    getPetById,
    createPet,
    updatePet,
    deletePet
};