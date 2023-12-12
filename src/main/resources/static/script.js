document.addEventListener('DOMContentLoaded', function() {
    let currentDogIndex = 0;
    let currentPage = 1;
    let dogsData = [];

    document.getElementById('like-button').addEventListener('click', function() {
        handleInteraction(true);
    });

    document.getElementById('dislike-button').addEventListener('click', function() {
        handleInteraction(false);
    });

    function handleInteraction(liked) {
        if (dogsData.length === 0 || dogsData[currentDogIndex] === undefined) {
            return;
        }

        const dogId = dogsData[currentDogIndex].id;
        sendInteraction(dogId, liked);
        removeCurrentDog();
        findNextDogWithImage();
    }

    function removeCurrentDog() {
        dogsData.splice(currentDogIndex, 1);
    }

    function findNextDogWithImage() {
        while (dogsData.length > 0 && (!dogsData[currentDogIndex] || !dogsData[currentDogIndex].photos || dogsData[currentDogIndex].photos.length === 0)) {
            removeCurrentDog();
        }
        if (dogsData.length === 0) {
            fetchDogsFromNextPage();
        } else {
            updateDogProfile(dogsData[currentDogIndex]);
        }
    }

    function fetchDogsFromNextPage() {
        fetch(`http://localhost:8080/dogs?page=${currentPage}&limit=10`)
            .then(response => response.json())
            .then(data => {
                if (data.dogs && data.dogs.length > 0) {
                    dogsData = data.dogs;
                    currentPage++;
                    findNextDogWithImage();
                } else {
                    console.log("No more dogs to load.");
                }
            })
            .catch(error => console.error('Error:', error));
    }

    function updateDogProfile(dog) {
        if (!dog) {
            return;
        }

        document.getElementById('dog-image').src = dog.photos[0] || 'default-dog.png';
        document.getElementById('dog-name').textContent = dog.name || '';

        const breed = dog.breedPrimary ? `Breed: ${dog.breedPrimary}` : '';
        const age = dog.age ? `, Age: ${dog.age}` : '';
        document.getElementById('dog-details').textContent = breed + age;

        if (dog.gender) {
            document.getElementById('dog-gender').textContent = `Gender: ${dog.gender}`;
        } else {
            document.getElementById('dog-gender').textContent = '';
        }

        if (dog.color) {
            document.getElementById('dog-color').textContent = `Color: ${dog.color}`;
        } else {
            document.getElementById('dog-color').textContent = '';
        }

        if (dog.description) {
            document.getElementById('dog-description').textContent = `Description: ${dog.description}`;
        } else {
            document.getElementById('dog-description').textContent = '';
        }
    }

    function sendInteraction(dogId, liked) {
        const data = {
            userId: "user1",
            petId: dogId,
            isLiked: liked
        };

        fetch('http://localhost:8080/interactions', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
    }
    fetchDogsFromNextPage();
});
