#version 330 core

layout (location = 0) out vec4 color;

in DATA
{
	vec2 tc;
	vec3 position;
} fs_in;

uniform vec2 bird;
uniform sampler2D tex;

void main() 
{
	vec3 myPos = fs_in.position;
	color = texture(tex, fs_in.tc);
	color *= 3.0 / (length(bird - myPos.xy) + 2.5) + 0.3;
}