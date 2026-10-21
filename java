const player = { name: 'Blastoise', hp: 100, maxHp: 100 };
const enemy = { name: 'Charizard', hp: 100, maxHp: 100 };

function updateHP() {
    document.getElementById('player-hp').style.width = (player.hp / player.maxHp) * 100 + '%';
    document.getElementById('enemy-hp').style.width = (enemy.hp / enemy.maxHp) * 100 + '%';
}

function playerAttack() {
    if (player.hp <= 0 || enemy.hp <= 0) return;

    const damage = Math.floor(Math.random() * 15) + 10;
    enemy.hp = Math.max(0, enemy.hp - damage);
    
    document.getElementById('battle-log').innerText = `${player.name} atacou e causou ${damage} de dano!`;
    updateHP();

    if (enemy.hp === 0) {
        document.getElementById('battle-log').innerText = `${enemy.name} foi derrotado! Você venceu!`;
        return;
    }

    setTimeout(enemyAttack, 1000);
}

function enemyAttack() {
    if (player.hp <= 0 || enemy.hp <= 0) return;

    const damage = Math.floor(Math.random() * 12) + 8;
    player.hp = Math.max(0, player.hp - damage);
    
    document.getElementById('battle-log').innerText = `${enemy.name} retaliou e causou ${damage} de dano!`;
    updateHP();

    if (player.hp === 0) {
        document.getElementById('battle-log').innerText = `${player.name} foi derrotado! Fim de jogo.`;
    }
}
