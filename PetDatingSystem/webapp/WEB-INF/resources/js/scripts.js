$(document).ready(function() {

	$('#petType').change(function() {
		var petTypeId = $(this).val();
		$('#breed option').hide();
		var first = true;

		$('#breed option').each(function() {
			var rel = $(this).attr('rel');
			if (rel == petTypeId) {
				$(this).show();
				if (first) {
					$('#breed').val($(this).val());
					first = false;
				}
			}
		});

	});

	$('#petType').change();
});